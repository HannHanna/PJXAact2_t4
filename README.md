# Actividad 2: Spring MVC, Thymeleaf y DTOs

## Respuestas del Cuestionario

a) ¿Qué es el patrón MVC y cómo se ve reflejado en tu proyecto (qué parte es el Modelo, cuál la Vista y cuál el Controlador)?
Es un patrón de arquitectura de software que separa las responsabilidades de la aplicación. En el proyecto se refleja de la siguiente manera: el Modelo está conformado por las clases DTO (ProductoDTO) que estructuran la información; la Vista corresponde a las plantillas de Thymeleaf (.html) encargadas de renderizar la interfaz gráfica en el navegador; y el Controlador son las clases anotadas con @Controller que gestionan las peticiones HTTP y conectan el modelo con la vista.

b) ¿Para qué sirve una clase DTO y por qué no simplemente usar la entidad directamente en la vista o en la petición?
Un DTO (Data Transfer Object) sirve para transportar datos de manera segura y específica entre las capas de la aplicación. No se debe usar la entidad de base de datos directamente para evitar sobreexponer atributos sensibles, acoplar innecesariamente la interfaz con la persistencia o lidiar con problemas de referencias circulares.

c) ¿Qué diferencia hay entre @ModelAttribute y @RequestBody? ¿Cuándo usarías cada uno?
@ModelAttribute se emplea para enlazar y recibir datos enviados desde un formulario web tradicional (url-encoded). Por otro lado, @RequestBody se utiliza en arquitecturas REST para deserializar de forma directa un objeto recibido en formato JSON (por ejemplo en peticiones hechas desde Postman o Bruno).

d) Enlaces de entrega y Endpoints de la API:

- Repositorio de GitHub: https://github.com/HannHanna/PJXAact2_t4
- Enlace en el VPS (Vistas Thymeleaf): http://167.71.180.74:8083/productos
- Endpoint REST de la API (POST JSON): http://167.71.180.74:8083/api/productos

Explicación breve de la API:
La aplicación cuenta con endpoints de tipo `@Controller` para renderizar las vistas dinámicas con Thymeleaf (listados en `/productos` y formularios mediante `@ModelAttribute`), así como un endpoint REST configurado con `@ResponseBody` y `@RequestBody` en `/api/productos` para la recepción y procesamiento de datos en formato JSON de manera independiente.
