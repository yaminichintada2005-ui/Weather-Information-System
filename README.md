# 🌦️ Weather Information System

A Java-based Weather Information System that fetches real-time weather information using REST APIs.

The application accepts a city name from the user, retrieves its geographical coordinates using the Open-Meteo Geocoding API, and then fetches the current weather details using the Open-Meteo Weather API.

---

## 📌 Features

- Search weather by city name
- Convert city name to latitude and longitude
- Fetch real-time weather information
- Display:
  - 🌡 Temperature
  - 💧 Relative Humidity
  - 🌬 Wind Speed
- JSON parsing using Jackson
- Clean layered architecture using Model and Service packages

---

## 🛠 Technologies Used

- Java 17
- Maven
- REST APIs
- Java HttpClient
- Jackson Databind
- JSON
- Eclipse IDE
- Git & GitHub

---

## 📂 Project Structure

```
WeatherInformationSystem
│
├── src/main/java
│
├── com.yamini
│   ├── Main.java
│   │
│   ├── model
│   │     ├── Weather.java
│   │     ├── CurrentWeather.java
│   │     ├── Location.java
│   │     └── LocationResponse.java
│   │
│   └── service
│         ├── GeoCodingService.java
│         └── WeatherService.java
│
└── pom.xml
```

---

## 🔄 Project Workflow

```
User
   │
   ▼
Enter City Name
   │
   ▼
GeoCodingService
   │
   ▼
Open-Meteo Geocoding API
   │
   ▼
Latitude & Longitude
   │
   ▼
WeatherService
   │
   ▼
Open-Meteo Weather API
   │
   ▼
Weather Information
   │
   ▼
Console Output
```

---

## 🚀 How to Run

1. Clone the repository

```bash
git clone https://github.com/yaminichintada2005-ui/Weather-Information-System.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Make sure Java 17 and Maven are installed.

4. Run:

```
Main.java
```

5. Enter any city name.

Example:

```
Enter City Name:
Hyderabad
```

Output:

```
City      : Hyderabad
Country   : India

Temperature : 31.5 °C
Humidity    : 72 %
Wind Speed  : 13.8 km/h
```

---

## 🌐 APIs Used

### Open-Meteo Geocoding API

Converts a city name into latitude and longitude.

### Open-Meteo Weather API

Provides current weather information using latitude and longitude.

---

## 📖 Concepts Learned

- REST API Consumption
- HTTP GET Requests
- Java HttpClient
- JSON Parsing
- Jackson ObjectMapper
- Java OOP
- Maven Dependency Management
- Layered Project Structure
- Git & GitHub

---

## 🔮 Future Enhancements

- Save weather history using MySQL
- JDBC Integration
- Exception Handling
- Search History
- Better Console UI
- Spring Boot REST API
- Web-based Frontend

---

## 👩‍💻 Author

**Yamini Chintada**

- GitHub: https://github.com/yaminichintada2005-ui

---

⭐ If you found this project useful, consider giving it a star!
