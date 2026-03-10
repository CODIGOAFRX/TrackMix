# TrackMix

**TrackMix** es una API REST desarrollada con **Java y Spring Boot** que permite registrar escuchas de canciones y generar estadísticas de consumo musical por usuario, similar a un sistema simplificado de analítica musical como Spotify Wrapped.

El proyecto está diseñado como práctica de backend moderno utilizando **arquitectura por capas, JPA/Hibernate y base de datos relacional**.

---

# Funcionalidades principales

### Gestión de usuarios

* Crear usuarios
* Listar usuarios
* Obtener detalle de usuario
* Actualizar información
* Borrado lógico

### Gestión de artistas

* Crear artistas
* Listar artistas
* Buscar artistas por nombre o género
* Actualizar información
* Eliminar artistas

### Gestión de canciones

* Crear canciones
* Listar canciones
* Obtener detalle
* Actualizar información
* Eliminar canciones

Cada canción está asociada a un artista mediante una relación **ManyToOne**.

---

# Registro de escuchas

TrackMix registra cada reproducción como un **evento individual de escucha**.

Endpoint:

```
POST /listenings
```

Ejemplo de payload:

```json
{
  "userId": 1,
  "trackId": 5,
  "timestamp": "2026-03-01T18:30:00",
  "durationListened": 180,
  "completed": true
}
```

Esto permite analizar el comportamiento musical del usuario posteriormente.

---

# Sistema de estadísticas

La API incluye varios endpoints para analizar hábitos musicales.

### Top canciones de un usuario

```
GET /stats/top-tracks?userId=1&limit=10
```

Devuelve las canciones más escuchadas por número de reproducciones.

---

### Top artistas de un usuario

```
GET /stats/top-artists?userId=1&limit=10
```

Agrupa las escuchas por artista.

---

### Uso diario

```
GET /stats/daily-usage?userId=1&from=2026-01-01&to=2026-01-31
```

Devuelve número de escuchas o minutos reproducidos por día.

Ideal para gráficos de actividad.

---

### Distribución por hora del día

```
GET /stats/hourly-usage?userId=1
```

Muestra en qué horas del día escucha más música el usuario.

---

### Estadísticas por género

```
GET /stats/by-genre?userId=1
```

Distribución del tiempo escuchado por género musical.

---

### Resumen anual tipo Wrapped

```
GET /stats/summary?userId=1&year=2026
```

Devuelve:

* Canción más escuchada
* Artista más escuchado
* Minutos totales escuchados
* Día con mayor actividad

---

# Tecnologías utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL / MySQL**
* **Lombok**
* **Maven**
* **Swagger / OpenAPI**

---

# Arquitectura del proyecto

El proyecto sigue una arquitectura por capas típica en aplicaciones Spring Boot:

```
controller
service
repository
model/entity
dto
config
```

Esto permite separar responsabilidades y mantener el código limpio y escalable.

---

# Modelo de datos principal

Las entidades principales del sistema son:

* **User**
* **Artist**
* **Track**
* **ListeningSession**

Relaciones principales:

```
Artist 1 ---- * Track
User 1 ---- * ListeningSession
Track 1 ---- * ListeningSession
```

---

# Objetivo del proyecto

Este proyecto forma parte de mi portfolio como desarrollador backend y tiene como objetivo practicar:

* diseño de APIs REST
* modelado de bases de datos
* consultas agregadas con JPA
* arquitectura limpia en Spring Boot
* análisis de datos de usuario

---

# Autor

Pedro Jesús Gómez Pérez

GitHub:
[https://github.com/CODIGOAFRX](https://github.com/CODIGOAFRX)
