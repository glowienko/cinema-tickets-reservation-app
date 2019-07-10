# cinema-tickets-reservation-app
Application that enables cinema tickets reservation.


Firstly you need to run database: 
docker run --name postgres1 -e POSTGRES_PASSWORD=mypass -p 5432:5432 -d postgres


example get available screenings: http://localhost:9999/screenings?start=2019-07-08T18:34&end=2019-07-08T20:40

