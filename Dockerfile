FROM openjdk:11-slim-buster
WORKDIR /etc/app
COPY mvnw mvnw.cmd pom.xml README.md ./
COPY .mvn ./.mvn
COPY backend/src ./backend/src
COPY backend/pom.xml backend/.gitignore ./backend/
COPY frontend/.browserslistrc frontend/.eslintrc.js frontend/.gitignore frontend/babel.config.js frontend/jest.config.js frontend/package.json frontend/package-lock.json frontend/pom.xml frontend/tsconfig.json frontend/vue.config.js frontend/yarn.lock ./frontend/
COPY frontend/public ./frontend/public
COPY frontend/src ./frontend/src
COPY frontend/tests ./frontend/tests
RUN ./mvnw package
ENTRYPOINT ["java", "-jar",  "backend/target/backend-0.0.1-SNAPSHOT.war", "--spring.profiles.active=containerized"]