# SuperHero-App

# Introducción

Este proyecto se trata de una App  __buscador de Super Heroes__, la cual obtiene los datos de estos mediante el consumo de una __API__ llamada __[Superhero API](https://www.superheroapi.com/)__.

Es una de las prácticas propuestas en el curso de [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8) el cual es gratis y si prefieres consumir más de su contenido, puedes visitar su [canal de YouTube:](https://www.youtube.com/@AristiDevs)

# Tecnologías Utilizadas

- Kotlin
- Retrofit
- Coroutines (Corrutinas)
- API REST - [Superhero API](https://www.superheroapi.com/)
- Picasso - Libreria para cargar imagenes desde una url
- Data Class
- Funciones Lambdas
- Diseño basado en XML
  - RecyclerView
  - CardView
  - Constraint Layout
  - Linear Layout

# Funcionalidad

La app está compuesta por dos vistas:

1. __Vista principal:__ En el buscador debemos escribir el __nombre__ o __palabra relacionada__ (por ejemplo, "Iron") con el superheroe que querramos buscar. Al presionar el icono "buscar" (lupa) en el teclado virtual del dispositivo, se mostrará un listado de resultados, relacionados con el __nombre__ o __palabra__ introducida.<br>

<p align="center">
      <img width="20%" src="https://i.postimg.cc/28261m1y/Screenshot-1.png">
  </p>

2. __Vista resultado:__ Para ver más información relacionada con alguno de los superheroes listados en pantalla, basta con presionar sobre el que se prefiera. Una vez hecho lo anterior, se mostrará una segunda pantalla que contiene información adicional del superheroe elegido como; ___Nombre verdadero del personaje___, ___Comic, Manga o Creador___ al que pertenece, y una gráfica con los niveles de sus ___Habilidades___ más sobresalientes.
   <br>

<p align="center">
      <img width="20%" src="https://i.postimg.cc/pTzrrFjM/Screenshot-2.png">
  </p>

# Acerca de Superhero API y Picasso

## Superhero API

Superhero API es una fuente de datos cuantificada y accesible programáticamente, de todos los superhéroes del universo cómico. Tomamos todo el material y lo juntamos en una forma que es más fácil de consumir con el software.

Se puede acceder a los datos a través de una API REST. Consulte la [documentación](https://www.superheroapi.com/) si desea comenzar.

## Picasso

Las imágenes agregan un contexto muy necesario y un toque visual a las aplicaciones de Android. [Picasso](https://square.github.io/picasso/) permite cargar imágenes sin problemas en su aplicación, ¡a menudo en una sola línea de código!

Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);
# Enlaces

- [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8)
- [Canal de YouTube de AristiDevs](https://www.youtube.com/@AristiDevs)
- [Superhero API](https://www.superheroapi.com/)
- [Libreria Picasso](https://square.github.io/picasso/) | [Repositorio GitHub](https://github.com/square/picasso)

### Extras

- [Android ImageView ScaleType: Una guía visual](https://thoughtbot.com/blog/android-imageview-scaletype-a-visual-guide)
- [JSON Editor Online](https://jsoneditoronline.org/)
- [ColorMagic: Generador de paletas de colores con IA](https://colormagic.app/)
- [Coolors: Generador de paletas de colores](https://coolors.co/)
- [Postimages: Almacenamiento gratuito de imágenes](https://postimages.org/es/)
