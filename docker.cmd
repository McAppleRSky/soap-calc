docker run --name postgres -e POSTGRES_PASSWORD=propaganda -p 5432:5432 -d postgres:10.20

docker run --name postgres -e POSTGRES_PASSWORD=propaganda -p 5432:5432 -d postgres:10.20 --volume./db

docker exec -it postgres psql -U postgres
