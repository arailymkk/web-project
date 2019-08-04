package kz.epam.webb.database;

public class Prep {
    public static void main(String[] args) {
        String songsList = "1,2,3,9,11";
        //String lit;
        Prep prep = new Prep();
        System.out.println(prep.addSongToUser(12, songsList));
        System.out.println(songsList);
        System.out.println(prep.addSongToUser(45, null));
    }
    public String addSongToUser(int id, String songsList) {
        if(songsList == null) {
            songsList = new String();
            return songsList + id;
        }
        else {
            return songsList + "," + id;
        }
    }

    private String[] parseSongsId(String songsList) {
        String [] ids = songsList.split(",");
        return ids;
    }
}
