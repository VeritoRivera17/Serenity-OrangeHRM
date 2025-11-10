
```
1. Conclusiones del ejercicio:

    - El flujo de la pagina web OrangeHRM es reproducible con Serenity BDD y Page Objects.
    - La interfaz requiere que los campos y botones se encuentren activos para la interaccion.
    - Este ejercicio demuestra la importancia de verificar no solo el login, sino la navegación interna y la actualización de datos críticos de los usuarios.


2. Riesgos / puntos a considerar:
   - La aplicación demo de OrangeHRM carga muchos elementos con JavaScript, por lo que hay que esperar a que estén visibles antes de interactuar.
   - Los selectores pueden cambiar entre versiones, por lo que conviene usar localizadores robustos, como IDs estables o atributos de datos, para que las pruebas sean menos frágiles.
   - Controlar la sincronización usando WebElementFacade o esperas de Serenity ayuda a que las pruebas sean más estables.

3. Recomendaciones:
   - Integrar WebDriverManager para evitar problemas con versiones de Chrome/ChromeDriver.
   - Añade logs y capturas de pantalla, por lo que Serenity ya toma screenshots cuando falla para ayudar en la depuración.
   - Agregar más comprobaciones, como verificar el estado del usuario y revertir cambios si es necesario.

```