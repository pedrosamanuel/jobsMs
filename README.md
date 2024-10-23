# Sistema de Microservicios con Java y Spring Boot

Este proyecto es una implementación de un sistema de microservicios utilizando **Java** con **Spring Boot**. El sistema gestiona entidades relacionadas con empleos, empresas y reseñas, empleando varias herramientas y patrones para garantizar la escalabilidad, resiliencia y monitoreo.

## Tecnologías utilizadas

<ul>
  <li><b>Java & Spring Boot:</b> Para la implementación de los microservicios y la lógica del negocio.</li>
  <li><b>OpenFeign:</b> Utilizado para la comunicación entre microservicios de manera declarativa.</li>
  <li><b>RabbitMQ:</b> Implementación de mensajería para la comunicación asincrónica entre microservicios.</li>
  <li><b>Spring Data JPA con PostgreSQL:</b> Cada microservicio tiene su propia base de datos independiente, utilizando PostgreSQL como base de datos y JPA para la persistencia de datos.</li>
  <li><b>Eureka Server:</b> Utilizado como servidor de registro, donde los microservicios se registran y descubren entre sí.</li>
  <li><b>Spring Cloud Gateway:</b> Para enrutar las solicitudes a los microservicios apropiados basados en las rutas y reglas definidas.</li>
  <li><b>Spring Boot Actuator & Zipkin:</b> Para monitoreo y rastreo distribuido de las transacciones a través de los microservicios.</li>
  <li><b>Resilience4j (Fault Tolerance & Circuit Breaking):</b> Implementación de patrones de tolerancia a fallos para manejar fallas en los servicios y evitar sobrecargas con circuit breakers.</li>
</ul>

## Arquitectura

El sistema se compone de varios microservicios que gestionan los empleos, las empresas y las reseñas asociadas. Cada microservicio es autónomo y tiene su propia base de datos para mantener la independencia de los datos:

<ul>
  <li><b>Microservicio Job:</b> Gestiona la creación, actualización y eliminación de empleos. Un empleo está asociado a una empresa.</li>
  <li><b>Microservicio Company:</b> Gestiona las empresas, permitiendo crear, actualizar y eliminar información sobre ellas.</li>
  <li><b>Microservicio Review:</b> Gestiona las reseñas de las empresas, permitiendo a los usuarios evaluar sus experiencias con diferentes compañías.</li>
</ul>
