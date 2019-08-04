<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Genres</title>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
        }

        body {
            color: #292929;
            font: 90% Roboto, Arial, sans-serif;
            font-weight: 300;
        }

        div#header {
            position: relative;
        }

        div#header h1 {
            height: 80px;
            line-height: 80px;
            margin: 0;
            padding-left: 10px;
            background: #e0e0e0;
            color: #292929;
        }

        div#header a {
            position: absolute;
            right: 0;
            top: 23px;
            padding: 10px;
            color: #006;
        }

        div#hiphop {
            background: #7cb71c;
            height: 400px;
        }

        div#rock {
            float: left;
            height: 400px;
            background: coral;
            width: 50%;
        }

        div#rnb {
            float: right;
            height: 400px;
            background: crimson;
            width: 50%;
        }

        div#jazz {
            clear: both;
            height: 600px;
            background: #147FA9;
        }
        div#pop {
            clear: both;
            height: 250px;
            background: #000066;
        }

        div#country {
            float: bottom;
            clear: both;
            background:  aqua;
            height: 350px;
        }

        div#wrapper1 {
            float: left;
            background: crimson;
            width: 55%;
            height: 1000px;
        }

        div#wrapper2 {
            float: right;
            width: 45%;
            height: 1000px;
            background: darkgreen;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <h1>Header</h1>
    </div>
    <div id="wrapper1">
        <a href="controller?command=rock"><div id="rock">Rock Playlist</div></a>
        <a href="controller?command=rnb"><div id="rnb">RnB Playlist</div></a>
        <a href="controller?command=jazz"><div id="jazz">Jazz Playlist</div></a>
    </div>
    <div id="wrapper2">
        <a href="controller?command=hiphop"><div id="hiphop">Hip-hop Playlist</div></a>
        <a href="controller?command=pop"><div id="pop">Pop Playlist</div></a>
        <a href="controller?command=country"><div id="country">Country Playlist</div></a>
    </div>
</div>
</body>
</html>
