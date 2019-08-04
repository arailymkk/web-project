package kz.epam.webb.database.dao;

import kz.epam.webb.database.connectionpool.ConnectionPool;
import kz.epam.webb.entity.Genre;
import kz.epam.webb.entity.Song;

import java.sql.*;
import java.util.*;

public class MusicDao {
    public static void main(String[] args) {
        MusicDao dao = new MusicDao();
//        Song song = dao.getSong(1);
//        System.out.println(song);
//        List<Song> songs = dao.getAllSongs();
//        System.out.println(songs);
//        dao.addSongToUser("muna", 21);
//        System.out.println(dao.deleteSongFromList(5, "1,2,3,4"));
//        dao.deleteSongFromUser("muna", 8);
        System.out.println(dao.getTopLatestReleasedSongs());

    }

    private static final String SELECT_SONG_BY_ID = "Select songname, singer, genre, releasedate From songs where idsong = ?";
    private static final String SELECT_SONG_BY_GENRE = "Select idsong, songname, singer, releasedate From songs where genre = ?";
    private static final String SELECT_SONGS = "Select * From songs";
    private static final String SELECT_SONGS_LIST= "Select songslist From userinfo where login = ?";
    private static final String UPDATE_SONGS_LIST = "UPDATE userinfo SET songslist = ?" + " WHERE login = ?;";

    private Connection connection;

    private List<Song> getSortedSongs(){
        List<Song> songs = getAllSongs();
        Collections.sort(songs, new Comparator<Song>() {
            public int compare(Song o1, Song o2) {
                return o2.getReleaseDate().compareTo(o1.getReleaseDate());
            }
        });
        return songs;
    }

    public List<Song> getTopLatestReleasedSongs() {
        return getSortedSongs().subList(0, 10);
    }

    public List<Song> getAllSongs() {
        List<Song> songs = null;
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_SONGS);
            if(resultSet != null) {
                songs = new ArrayList<>();
                while (resultSet.next()) {
                    songs.add(getSong(resultSet.getInt("idsong")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return songs;
    }

    public Song getSong(int id) {
        Song song = null;
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                song = new Song();
                song.setId(id);
                song.setName(resultSet.getString(1));
                song.setSinger(resultSet.getString(2));
                song.setGenre(Genre.valueOf(resultSet.getString(3).toUpperCase()));
                song.setReleaseDate(resultSet.getDate(4));
                return song;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return song;
    }

    public List<Song> getSongsByLogin(String login) {
        List<Song> songs = new ArrayList<>();
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONGS_LIST)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
               String songsList = resultSet.getString(1);
               String [] parsedSongsList = parseSongsId(songsList);
               for(String id: parsedSongsList) {
                   Song song = getSong(Integer.parseInt(id));
                   songs.add(song);
               }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return songs;
    }

    public void deleteSongFromUser(String login, int songId) {
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SONGS_LIST)) {
            String newSongsList = deleteSongFromList(songId, getSongsAsList(login));
            preparedStatement.setString(1, newSongsList);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
    }

    public void addSongToUser(String login, int songId) {
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SONGS_LIST)) {
            String newSongsList = addSongToList(songId, getSongsAsList(login));
            preparedStatement.setString(1, newSongsList);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
    }

    public List<Song> getSongsByGenre(String genre){
        List<Song> songs = new ArrayList<>();
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG_BY_GENRE)) {
            preparedStatement.setString(1, genre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Song song = new Song();
                song.setId(resultSet.getInt(1));
                song.setName(resultSet.getString(2));
                song.setSinger(resultSet.getString(3));
                song.setGenre(Genre.valueOf(genre.toUpperCase()));
                song.setReleaseDate(resultSet.getDate(4));
                songs.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return songs;
    }

    private String getSongsAsList(String login){
        String songsList = null;
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONGS_LIST)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                songsList = resultSet.getString(1);
                //String newSongsList = addSongToList(songId, songsList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return songsList;
    }

    private String[] parseSongsId(String songsList) {
        String [] ids = songsList.split(",");
        return ids;
    }

    private String deleteSongFromList(int id, String songsList){
        String [] parsedList = parseSongsId(songsList);
        String newSongsList = "";
        for(int i = 0; i < parsedList.length; i++) {
            if(Integer.parseInt(parsedList[i]) != id){
                if(newSongsList.length() != 0) {
                    newSongsList += "," + parsedList[i];
                }
                else {
                    newSongsList += parsedList[i];
                }
            }
        }
        return newSongsList;
    }

    private String addSongToList(int id, String songsList) {
        if(songsList == null) {
            songsList = new String();
            return songsList + id;
        }
        else {
            if(!checkExistence(songsList, id)) {
                return songsList + "," + id;
            }
            else {
                System.out.println("already exists");
                return songsList;
            }
        }
    }

    private boolean checkExistence(String songsList, int id) {
        if(songsList == null) {
            return false;
        }
        String[] parsedIds = parseSongsId(songsList);
        for(String songId: parsedIds) {
            if(Integer.parseInt(songId)==id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistenceOfSong(String login, int id) {
        return checkExistence(getSongsAsList(login), id);
    }
}
