<?php
require_once ("db.php");

$projektausschreibungenQuery = "  SELECT * 
            FROM juniter_einfuehrung.projektausschreibungen";
$schulungenQuery = "  SELECT * 
            FROM juniter_einfuehrung.schulungen";
$workshopsQuery = "  SELECT * 
            FROM juniter_einfuehrung.workshops";
$sporteventsQuery = "  SELECT * 
            FROM juniter_einfuehrung.sportevents";

$projektausschreibungenStatement = $conn->prepare($projektausschreibungenQuery);
$schulungenStatement = $conn->prepare($schulungenQuery);
$workshopsStatement = $conn->prepare($workshopsQuery);
$sporteventsStatement = $conn->prepare($sporteventsQuery);

$projektausschreibungenStatement->execute();
$schulungenStatement->execute();
$workshopsStatement->execute();
$sporteventsStatement->execute();

$projektausschreibungencontent = "";
foreach ($projektausschreibungenStatement as $row) {
    $projektausschreibungencontent .= 
        "<tr>
            <td>{$row["kunde"]}</td>
            <td>{$row["projektscope"]}</td>
            <td>{$row["umfang"]}</td>
            <td>{$row["gesuchtePositionen"]}</td>
            <td>{$row["bewerbungsfrist"]}</td>
        </tr>";
}
$projektausschreibungencontent = 
"<table>
    <tr>
        <th>Kunde</th>
        <th>Projektscope</th>
        <th>Umfang</th>
        <th>Gesuchte Positionen</th>
        <th>Bewerbungsfrist</th>
    </tr>
    {$projektausschreibungencontent}
</table>";

$schulungencontent = "";
foreach ($schulungenStatement as $row) {
    $schulungencontent .= 
        "<tr>
            <td>{$row["titel"]}</td>
            <td>{$row["trainer"]}</td>
            <td>{$row["niveau"]}</td>
            <td>{$row["datum"]}</td>
            <td>{$row["zeit"]}</td>
            <td>{$row["ort"]}</td>
        </tr>";
}
$schulungencontent = 
"<table>
    <tr>
        <th>Titel</th>
        <th>Trainer</th>
        <th>Niveau</th>
        <th>Datum</th>
        <th>Zeit</th>
        <th>Ort</th>
    </tr>
    {$schulungencontent}
</table>";

$workshopscontent = "";
foreach ($workshopsStatement as $row) {
    $workshopscontent .= 
        "<tr>
            <td>{$row["anbieter"]}</td>
            <td>{$row["thema"]}</td>
            <td>{$row["datum"]}</td>
            <td>{$row["zeit"]}</td>
            <td>{$row["ort"]}</td>
        </tr>";
}
$workshopscontent = 
"<table>
    <tr>
        <th>Anbieter</th>
        <th>Thema</th>
        <th>Datum</th>
        <th>Zeit</th>
        <th>Ort</th>
    </tr>
    {$workshopscontent}
</table>";

$sporteventscontent = "";
foreach ($sporteventsStatement as $row) {
    $sporteventscontent .= 
        "<tr>
            <td>{$row["titel"]}</td>
            <td>{$row["maximaleTeilnehmerzahl"]}</td>
            <td>{$row["datum"]}</td>
            <td>{$row["zeit"]}</td>
            <td>{$row["ort"]}</td>
        </tr>";
}
$sporteventscontent = 
"<table>
    <tr>
        <th>Titel</th>
        <th>Maximale Teilnehmerzahl</th>
        <th>Datum</th>
        <th>Zeit</th>
        <th>Ort</th>
    </tr>
    {$sporteventscontent}
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
              <a href="#Projektausschreibungen">Projektausschreibungen</a>
            </li>
            <li class="menu-main-menu-item">
              <a href="#Schulungen">Schulungen</a>
            </li>
            <li class="menu-main-menu-item">
              <a href="#Workshops">Workshops</a>
            </li>
            <li class="menu-main-menu-item">
              <a href="#Sportevents">Sportevents</a>
            </li>
            <li class="menu-main-menu-item">
              <a href="private.php">Log in</a>
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
            <span class="las la-clipboard-list"></span>
          </div>
          <div class="column-title">
            <h4>Projektausschreibungen</h4>
          </div>
        </div>
        <div class="column">
          <div class="column-logo">
            <span class="las la-graduation-cap"></span>
          </div>
          <div class="column-title">
            <h4>Schulungen</h4>
          </div>
        </div>
        <div class="column">
          <div class="column-logo">
            <span class="las la-school"></span>
          </div>
          <div class="column-title">
            <h4>Workshops</h4>
          </div>
        </div>
        <div class="column">
          <div class="column-logo">
            <span class="las la-table-tennis"></span>
          </div>
          <div class="column-title">
            <h4>Sportevents</h4>
          </div>
        </div>
      </div>
    </div>
    <div class="tables">
      <div class="projektausschreibungen table"><a name="Projektausschreibungen"></a>
        <div class="card">
          <div class="card-header">
            <h3>Projektausschreibungen</h3>
          </div>
          <div class="card-body">
            <?php  echo $projektausschreibungencontent  ?>
          </div>
        </div>
      </div>
      <div class="schulungen table"><a name="Schulungen"></a>
        <div class="card">
          <div class="card-header">
            <h3>Schulungen</h3>
          </div>
          <div class="card-body">
            <?php  echo $schulungencontent  ?>
          </div>
        </div>
      </div>
      <div class="workshops table"><a name="Workshops"></a>
        <div class="card">
          <div class="card-header">
            <h3>Workshops</h3>
          </div>
          <div class="card-body">
            <?php  echo $workshopscontent  ?>
          </div>
        </div>
      </div>
      <div class="sportevents table"><a name="Sportevents"></a>
        <div class="card">
          <div class="card-header">
            <h3>Sportevents</h3>
          </div>
          <div class="card-body">
            <?php  echo $sporteventscontent  ?>
          </div>
        </div>
      </div>
      
    </div>
  </main>

  

</body>
</html>