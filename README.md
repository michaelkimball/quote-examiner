# Quote-Examiner

Quote-Examiner is a Spring Boot application that parses a block of text and saves some metadata from it. It uses MySQL, Thymeleaf, Bootstrap, Vue.js, Spring Data REST and Apache OpenNLP.

## Running

To run this application

```bash
./mvnw spring-boot:run
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

## Usage

Open page:
```bash
http://localhost:8080
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)