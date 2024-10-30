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
<h2>Docker</h2>

<p>Este archivo <code>docker-compose.yml</code> define la infraestructura básica para el sistema de microservicios, utilizando Docker para crear y gestionar los contenedores necesarios. Cada servicio en este archivo tiene un propósito específico:</p>

<ul>
  <li>
    <strong>PostgreSQL:</strong> 
    <p>Proporciona una base de datos relacional para almacenar datos de la aplicación. La configuración define un usuario y contraseña predeterminados, y monta un volumen persistente para conservar los datos entre reinicios.</p>
  </li>
  <li>
    <strong>pgAdmin:</strong> 
    <p>Una herramienta de administración de base de datos que permite interactuar y gestionar la instancia de PostgreSQL a través de una interfaz gráfica accesible en el navegador. La configuración incluye un correo y contraseña de acceso por defecto, y expone el puerto <code>5050</code> en la máquina local.</p>
  </li>
  <li>
    <strong>Zipkin:</strong> 
    <p>Proporciona rastreo distribuido para la arquitectura de microservicios. Permite monitorear y visualizar la latencia de las solicitudes en cada servicio, ayudando a identificar problemas de rendimiento. Se expone en el puerto <code>9411</code>.</p>
  </li>
  <li>
    <strong>RabbitMQ:</strong> 
    <p>Un sistema de mensajería que facilita la comunicación asíncrona entre los microservicios. Incluye la interfaz de administración en el puerto <code>15672</code> y el puerto de mensajería en <code>5672</code>, permitiendo una gestión eficiente y la visualización del tráfico de mensajes.</p>
  </li>
</ul>

<p>El uso de Docker en esta configuración facilita la administración de dependencias de la aplicación y permite un entorno controlado y reproducible en desarrollo y producción.</p>

