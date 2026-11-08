# JFo 5.1 - Expresiones boolean y construcciones if/else

Esta carpeta contiene 15 actividades autocorregibles.

## Actividades

01. Corrige variables boolean mal declaradas
02. Corrige asignación y comparación
03. Corrige operadores relacionales incorrectos
04. Corrige un if sin condición booleana
05. Corrige la comparación de String
06. Declara y muestra valores booleanos
07. Comprueba si una edad permite conducir
08. Comprueba si un número es positivo
09. Comprueba si una nota aprueba
10. Comprueba si un número es par o impar
11. Clasificador de temperatura
12. Control de stock en carrito
13. Validador de acceso por edad
14. Comparador de dos números
15. Identificador de usuario especial

Cada subcarpeta `actividadNN` es un proyecto Maven independiente con tests JUnit 5 y workflow de GitHub Actions.

## Cómo entregar las actividades

La rama `main` está protegida: contiene los enunciados originales y no se puede modificar.
Cada alumno trabaja en **su propia rama**, con su nombre.

1. Clona el repositorio:
   `git clone https://github.com/java-foundations-2026-malaga/REPOSITORIO.git`
2. Crea tu rama con tu nombre y apellido, en minúsculas y sin tildes ni espacios (por ejemplo `juan-perez`):
   `git checkout -b juan-perez`
   (En Eclipse: botón derecho sobre el proyecto > `Team > Switch To > New Branch...`).
3. Importa en Eclipse la carpeta `actividadNN` que vayas a hacer (`File > Import... > Maven > Existing Maven Projects`), resuélvela y comprueba los tests con `Run As > JUnit Test`.
4. Haz commit y sube **tu rama**:
   `git add .` → `git commit -m "Actividad NN"` → `git push -u origin juan-perez`
   (En Eclipse: `Git Staging` > `Commit and Push...`).
5. En la pestaña **Actions** del repositorio verás el resultado de la autocorrección de cada actividad que hayas modificado: ✅ aprobada o ❌ con los errores.

Si al hacer push te aparece un error sobre `main`, es que estás en la rama equivocada: cambia a tu rama con `git checkout juan-perez`.
