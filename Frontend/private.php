<?php
require_once ("db.php");

$bewerbungenQuery = "  SELECT * 
            FROM juniter_einfuehrung.bewerbungen";
$anmeldungenQuery = "  SELECT * 
            FROM juniter_einfuehrung.anmeldungen";

$bewerbungenStatement = $conn->prepare($bewerbungenQuery);
$anmeldungenStatement = $conn->prepare($anmeldungenQuery);

$bewerbungenStatement->execute();
$anmeldungenStatement->execute();

$bewerbungencontent = "";
foreach ($bewerbungenStatement as $row) {
    $bewerbungencontent .= 
        "<tr>
            <td>{$row["projekt"]}</td>
            <td>{$row["stand"]}</td>
        </tr>";
}
$bewerbungencontent = 
"<table>
    <tr>
        <th>Projekt</th>
        <th>Stand</th>
    </tr>
    {$bewerbungencontent}
</table>";

$anmeldungencontent = "";
foreach ($anmeldungenStatement as $row) {
    $anmeldungencontent .= 
        "<tr>
            <td>{$row["event"]}</td>
            <td>{$row["stand"]}</td>
        </tr>";
}
$anmeldungencontent = 
"<table>
    <tr>
        <th>Event</th>
        <th>Stand</th>
    </tr>
    {$anmeldungencontent}
</table>";

$conn = null;

?>
<!DOCTYPE html>
<html lang="de-DE">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
  <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" id="hestia-google-font-montserrat-css" href="//fonts.googleapis.com/css?family=Montserrat%3A300%2C400%2C500%2C700&subset=latin&ver=5.5.8" type="text/css" media="all">
  <link rel="stylesheet" id="google-fonts-1-css" href="https://fonts.googleapis.com/css?family=Montserrat%3A100%2C100italic%2C…700%2C700italic%2C800%2C800italic%2C900%2C900italic&display=auto&ver=5.5.8" type="text/css" media="all">
  
  <title>Integrationsaufgabe Carlos Sulbaran</title>
  <link rel="stylesheet" href="style2.css">
</head>
<body>
  <header class="header" >
    <nav class="navbar">
      <div class="container">
        <div class="navbar-header">
          <div class="logo-wrapper">
            <a class="navbar-brand" href="https://juniter.de/" title="JunITer">
              <img src="https://juniter.de/wp-content/uploads/2020/10/cropped-logo-4.png" alt="JunITer"></img>
            </a>
          </div>
        </div>
        <div id="main-navigation" class="main-navigation">
          <ul id="menu-main-menu" class="menu-main-menu">
            <li class="menu-main-menu-item">
              <a href="#Bewerbungen">Bewerbungen</a>
            </li>
            <li class="menu-main-menu-item">
              <a href="#Anmeldungen">Anmeldungen</a>
            <li class="menu-main-menu-item">
              <a href="index.php">Log out</a>
            </li>
        </div>
      </div>
    </nav>
  </header>
  <main>
    <div class="cards">
      <div class="container columns">
        <div class="column">
          <div class="column-logo">
            <span class="las la-user-circle"></span>
          </div>
          <div class="column-title">
            <h4>Bewerbungen</h4>
          </div>
        </div>
        <div class="column">
          <div class="column-logo">
            <span class="las la-clipboard-list"></span>
          </div>
          <div class="column-title">
            <h4>Anmeldungen</h4>
          </div>
        </div>
      </div>
    </div>
    <div class="tables">
      <div class="bewerbungen table"><a name="Bewerbungen"></a>
        <div class="card">
          <div class="card-header">
            <h3>Bewerbungen</h3>
          </div>
          <div class="card-body">
            <?php  echo $bewerbungencontent  ?>
          </div>
        </div>
      </div>
      <div class="anmeldungen table"><a name="Anmeldungen"></a>
        <div class="card">
          <div class="card-header">
            <h3>Anmeldungen</h3>
          </div>
          <div class="card-body">
            <?php  echo $anmeldungencontent  ?>
          </div>
        </div>
      </div>     
    </div>
  </main>
</body>
</html>