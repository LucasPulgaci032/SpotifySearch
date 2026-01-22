# 🎵 SpotifySearch

**SpotifySearch** is a Java Maven web project that allows you to search for artist information using the **Spotify Web API** and **Last.fm API**.

The project demonstrates how to consume external APIs in Java, parse JSON responses and deploy a web application using **Apache Tomcat**.

---

## ✨ Features

- 🔍 Search artists by name
- ⭐ Artist popularity
- 🖼️ Profile image
- 🎼 Musical genres
- 👥 Number of followers
- 🆔 Spotify ID and metadata
- 🔐 Secure API credentials using `.env`

---

## 🧠 How it works

1. The user provides an artist name
2. The application sends HTTP requests to:
    - Spotify Web API
    - Last.fm API
3. The APIs return JSON responses
4. JSON is parsed into Java objects using **Gson**
5. Artist information is displayed to the user

---

## 🛠️ Technologies Used

- Java
- Maven
- Apache Tomcat 10.1
- Spotify Web API
- Last.fm API
- Jakarta Servlet API
- Gson (JSON parsing)
- Dotenv (environment variables)

---

## 🚀 Step-by-step setup

### 1️⃣ Create a Spotify Developer Application

1. Go to **Spotify for Developers**
2. Log in with your Spotify account
3. Create a new application
4. Copy your:
    - **Client ID**
    - **Client Secret**

---

### 2️⃣ Create a Last.fm Developer Application

1. Go to **Last.fm – Get an API account**
2. Generate your **API_KEY**

---

### 3️⃣ Configure environment variables

Create a `.env` file in the root of the project:

```env
CLIENT_ID=your_client_id_here
CLIENT_SECRET=your_client_secret_here
API_KEY=your_lastfm_api_key

```
### 4️⃣ Install Apache Tomcat
1. Download Apache Tomcat 10.1.50
2. Extract it to a local directory, for example:

```
C:\apache-tomcat-10.1.50
```

### 5️⃣ Configure the pom.xml
This project uses Maven and must be packaged as a WAR to run on Tomcat.

5.1 Set the packaging type :
```pom.xml
   <packaging>war</packaging>
```
5.2 Add required dependencies:

You must add the following dependencies to your pom.xml:

🔹 Jakarta Servlet API

Used to create servlets.
Provided by Tomcat at runtime.

```pom.xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```
🔹 Gson

Used to parse JSON responses from Spotify and Last.fm APIs into Java objects.

```pom.xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```
🔹 Dotenv

Used to load environment variables from the .env file securely.
```pom.xml
  <dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>
```

▶️ Build and Deploy the application

6️⃣ Compile the project with Maven

In the root directory of the project, run:

```bash
  mvn clean compile
```
To generate the deployable file, run:


```bash
 mvn clean package
```
This command creates a .war file inside the target/ directory.

7️⃣ Deploy the application to Tomcat
  1. Locate the generated file:

 ```
 target/SpotifySearch.war
 ```
 2. Copy the .war file to Tomcat’s webapps directory:

 ```
 apache-tomcat-10.1.50/webapps

 ```

8️⃣ Start Tomcat
  
  1. Go to the Tomcat bin directory:

```
 apache-tomcat-10.1.50/bin
```
  2. Run:

```
 startup.bat

```

9️⃣ Access the application

Open your browser and go to:

```
  http://localhost:8080/SpotifySearch

```

***Now, your SpotifySearch server is running in the browser. To use this server and its API, clone the SpotifySearch-UI repository using:***
 ```bash
   git clone https://github.com/LucasPulgaci032/SpotifySearch-UI
 ```