# Streaming Charts
Zu Programmieren ist ein Streaming Chart Manager. Es sind Songs einzulesen, auszuwerten und Files zu schreiben

Es ist wichtig, eine Trennung zwischen Lied, der Chart Verwaltung und der User-Interaktion zu haben!
Text zwischen spitzen Klammern <> ist mit passendem Text zu ersetzen. 

Achte auf richtige Projekstruktur, Clean-Code-Rules, Objektorientierung etc.

## File
Das File beinhaltet Lieder, die durch Track-ID, Interpreten, Lied und Album gekennzeichnet sind. Die Track-ID ist nicht eineindeutig. Außerdem besitzt jedes Lied einen stream-counter. Auch ist es jedes Lied einem fixen Genre zugeordnet (Rock, Pop, Indie, Nineties)

Genre;Trackid;Interpret;Album;Song:stream-counter
Pop;19;Cyndi Lauper;She's So Unusual;Girls Just Want to Have Fun;35
Rock;11;The Doors;The Doors;Light My Fire;14
Nineties;59;TLC;CrazySexyCool;Waterfalls;56
Rock;6;Pink Floyd;The Dark Side of the Moon;Time;38
(etc....)

## Anzeige der Lieder
Entwickle eine Möglichkeit, alle Lieder in folgendem Format auszugeben. Die Felder sind wie folgt zu formatieren (alles links bündig)
Interpret: 35 Zeichen, Album: 75 Zeichen, Track-ID: 2 Zeichen, Song: 55 Zeichen, Genre: Wie es ist
<Interpret> | <Album> |#<Track-ID>: <Song><2 Tabs>(<Genre>)

zB
Cyndi Lauper                        | She's So Unusual                                                            |#19: Girls Just Want to Have Fun                            		(POP)
The Doors                           | The Doors                                                                   |#11: Light My Fire                                          		(ROCK)


### Anzeige eines Genres 
Zeige nur Lieder eines durch den:die Benutzer:in Genres an im Format: 
<Interpret> | <Album> |#<Track-ID>: <Song>
Die Felder sind wie folgt zu formatieren (alles links bündig)
Interpret: 35 Zeichen, Album: 75 Zeichen, Track-ID: 2 Zeichen, Song: 55 Zeichen

zB
Cyndi Lauper                        | She's So Unusual                                                            |#19: Girls Just Want to Have Fun

## streaming-charts
Entwickle eine Möglichkeit, alle Lieder eines Genres (user-Interaktion!) 
in einer sortierten Map nach ihrem stream-count abzulegen. 
Haben zwei Lieder den selben counter, zieht das zuerst hinzugefügte Lied. 
Gib als Hinweis aus, welches Lied übersprungen wurde

Erstelle daraus die streaming-charts in aufsteigender Reihenfolge (von niedrigsten zum top-Eintrag.) 
und gib die Lieder in folgendem Format aus: 

Nr. <Chart-Eintrag>: <Interpret> - <Song> (Streaming-Counter: <stream-counter>)
zB
Nr. 15: Katy Perry - Firework (Streaming-Counter: 4)
Nr. 14: Rihanna - Umbrella (Streaming-Counter: 7)

## Abfrage Mindest-Stream
Es soll herausgefunden werden, welche Lieder mindestens X Mal gespielt wurden.
Frage den:die Benutzer:in, um eine Eingabe für X.

Gib anschließend alle Lieder unabhängig von Genre aus, die mindestens X Mal abgespielt wurden 

Output:
Please tell me the minimum streaming times you wish to filter?

Input:
40

Output
<Interpret> (on '<album>'): <Song> (Streaming-Counter: <stream-counter>)


## File schreiben
Schreibe alle Songs pro Genre (wird durch den:die Benutzer:in selektiert) in ein File nach dem Muster:
exam/<genre>/songs.txt
Also zum Beispiel: 
exam/ROCK/songs.txt

Für alle Lieder mit einem stream-Counter von kleiner 50, sieht das Format wie folgt aus:
Artist: <Interpret>
Album: <Album>
<1Tab>Song# <Trackid 2-Stellig>
<2Tabs>Song: <Song>
Stream-Counter:<stream-counter 2-Stellig>
<Eine Leerzeile>
Artist: <Interpret>
(....)

Für alle mit mindestens 50 so:
<strong>
Artist: <Interpret>
Album: <Album>
<1Tab>Song# <Trackid 2-Stellig>
<2Tabs>Song: <Song>
Stream-Counter:<stream-counter 2-Stellig>
</strong>
<Eine Leerzeile>
<strong>
(....)

Gib eine Meldung aus, sobald ein Genre-File geschrieben wurde!


## Zusatzpunkte
### Statistiken. Max 10 Punkte
#### Meist-gehörte Songs +5 Punkte

Finde alle Songs, die mindestens 50x gestreamt wurden.
Ausgabe nach Genre gruppiert. 
#### Am wenisgesten gehörte Songs: + 5 Punkte
Finde alle Songs, die nicht öfter als 20x gestreamt wurden.
Ein- und Ausgabe nach eigenem Ermessen
Ausgabe nach Genre gruppiert. 

### Notizen (max 11 Punkte)
#### Erfassen von Notizen: +5p
Jedes Lied kann eine Liste von Notizen erfassen, sobald der Stream-Counter >= 30  ist
Ablauf
- Anzeige Aller in Frage kommenden Songs
- Auswahl Song mittels Song-Titel
- Notiz erfassen.

#### Anzeige von Notizen zu einem Ticket: +3 Punkte
Zu jedem Lied mit Stream-Counter >= 30 die entsprechenden Notizen anzeigen lassen.

Ablauf: 
- Anzeige Aller in Frage kommenden Songs
- Auswahl Song mittels Song-Titel
- Anzeige Notizen ODER: "There are not notes", wenn es keine Notizen gibt

#### Ausgabe der Notizen im File: +3 Punkte
Artist: <Interpret>
Album: <Album>
<1Tab>Song# <Trackid>
<2Tabs>Song: <Song>
Stream-Counter:<stream-counter>
<3Tabs><Jede notiz in einer eigenen Zeile>

### Ermittle den Stream-Count aller Alben. +8 Punkte
Zähl dazu alle stream-counts aller Lieder eines Albums zusammen. Gib das Album und den ermittelten Wert aus. Es ist nicht notwendig, weitere Informationen auszugeben (Alben-Titel sind eineindeutig).

### Unit Tests
Pro sinnvollem Unittest +2 Punkte, max +10 Punkte