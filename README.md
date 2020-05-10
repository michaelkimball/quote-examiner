# Quote-Examiner

Quote-Examiner is a Spring Boot application that parses a block of text and saves some metadata from it. It uses MySQL, Vue.js (Vuex, Jest & Typescript), Spring Data REST and Apache OpenNLP.

![Quote Examiner Screenshot](https://github.com/michaelkimball/quote-examiner/blob/master/quote-examiner-screenshot.png)

## Running

To run this application:

```bash
./mvnw clean install
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar
```

To run MySQL using docker:
```bash
docker-compose up db
```

To run app using docker if using Mac/Linux:
```bash
docker-compose up
```

To run app using docker if using Windows:
1. `set COMPOSE_CONVERT_WINDOWS_PATHS=1`
2. Then open Docker Desktop Settings->File Sharing and enable the drive that you have cloned the repo to.
3. Restart Docker Desktop
4. `docker-compose up`

To run this app in development mode:
```bash
backend
**********
./mvnw -f backend/pom.xml spring-boot:run

frontend
**********
cd frontend
npm install
npm run start
```
Note that in development mode the frontend runs at `http://localhost:8081` by default.

## Usage

Open page:
```bash
http://localhost:8080
```

Check swagger:
```bash
http://localhost:8080/swagger-ui.html
```

## Table Structure

|  column  |   data type   |
| -------- | ------------- |
|   id     | bigint(20) PK |
| original |    longtext   |
| stripped |    longtext   |
|   nouns  |    int(11)    |
|   verbs  |    int(11)    |
|  periods |    int(11)    |
|   you    |    int(11)    |
|   that   |    int(11)    |
|   thing  |    int(11)    |
|   they   |    int(11)    |

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)