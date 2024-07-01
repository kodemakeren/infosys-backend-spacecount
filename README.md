Spring Boot applikasjon med to endepunkter:
- Ett som viser hvilke astronauter er på hvilke romskip i nåtid.
- Ett som viser hvilket romskip en astronaut befinner seg på.
For å starte applikasjonen trengs Maven og Java 17. Når dette er installert startes den med: mvn spring-boot:run

Da kan man aksessere to endepunkter på:
http://localhost:8080/astronauts/NAVNPÅROMSTASJON (ISS eller Tiangong)
Da får man en liste med navn på astronauter og en id assosiert med astronauten man kan senere bruke for å se hvilket romskip denne befinner seg på.

F.eks:
{
id: 4,
name: "Oleg Kononenko"
},

Da gjenbruker man "4" i tjenesten som viser romskipet hen befinner på.

http://localhost:8080/spacecraft/4

Da får man svar som følger:

{
id: 2,
name: "ISS"
}

Som viser at ISS er denne astronautens nåværende hjem.
