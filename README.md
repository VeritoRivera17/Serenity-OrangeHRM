<<<<<<< HEAD
# Serenity-OrangeHRM
=======

```
Proyecto: Serenity OrangeHRM Demo - Actualizar usuario

Requisitos (recomendados):
- Java 21 (JDK 21)
- Maven 3.8+
- Google Chrome (versión reciente) y ChromeDriver que coincida con la versión de Chrome **o** usar WebDriverManager (recomendado)
- Sistema operativo: Windows / Linux / macOS

Dependencias y versiones críticas (ver pom.xml):
- Serenity BDD 4.2.34
- Selenium 4.21.0
- JUnit 5.10.2 (a través de BOM)

Instrucciones de ejecución:
1. Clona el repositorio:
   git clone https://github.com/<tu_usuario>/Serenity-OrangeHRM-Exercise.git
   cd Serenity-OrangeHRM-Exercise

2. (Opcional pero recomendado) Añade WebDriverManager al pom.xml o instala ChromeDriver y agrégalo al PATH.
   - Si prefieres usar WebDriverManager, añade al pom.xml:
     <dependency>
       <groupId>io.github.bonigarcia</groupId>
       <artifactId>webdrivermanager</artifactId>
       <version>5.5.1</version>
     </dependency>

3. Ejecutar pruebas desde consola (ejemplo):
   mvn clean verify -Dwebdriver.driver=chrome

   - `mvn verify` ejecutará las pruebas y luego el plugin serenity-maven-plugin agregará los reportes.
   - Si usas `mvn -Dserenity.project.name="Serenity-OrangeHRM" test` o `mvn -Dwebdriver.base.url=...` puedes ajustar configuración en línea.

4. Reportes:
   - Después de la ejecución, los reportes HTML estarán en `target/site/serenity` (ver configuración en pom.xml y plugin).

Notas importantes:
- Si obtienes errores sobre ChromeDriver: instala ChromeDriver y agrega su carpeta al PATH o usa WebDriverManager.
- Revisa `serenity.conf` para valores de `environment` y credenciales. En este ejercicio usaremos el login estándar: `Admin` / `admin123`.
- Si los selectores fallan (página cambia), abre DevTools y ajusta los locators en `AdminUsersPage.java`.

```
>>>>>>> 02388cf (Primer commit: Proyecto Serenity BDD OrangeHRM)
