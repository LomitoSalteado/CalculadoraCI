# 🧮 CalculadoraCI

Proyecto Java con Maven que implementa una calculadora básica, pruebas automatizadas con JUnit y pipeline de integración continua (CI) usando GitHub Actions.

public class Operaciones {

    private Operaciones() {}

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}


---

## 📌 Objetivos

- Aprender a configurar un proyecto Java con Maven. 
- Implementar pruebas unitarias atómicas e independientes  
- Automatizar compilación y testing con CI/CD  
- Documentar cada paso del flujo de trabajo  

---

### 🧱 Estructura del proyecto
- `src/main/Operaciones.java`: contiene la lógica de la calculadora  
- `src/test/OperacionesTest.java`: contiene las pruebas unitarias  
- `pom.xml`: configuración de Maven y dependencias  
- `.gitignore`: evita subir archivos innecesarios  
- `.github/workflows/ci.yml`: define el pipeline CI

#### ⚙️ Configuración de Maven

Se agregó la dependencia JUnit 5 para ejecutar pruebas.

<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
  </dependency>
</dependencies>


##### 🧪 Pruebas unitarias con JUnit

Se implementaron cinco pruebas atómicas e independientes para validar las operaciones básicas de la calculadoraCI

    @Test
    void testSumar() {
        assertEquals(7, Operaciones.sumar(3, 4), "La suma de 3 + 4 debe ser 7");
    }

    @Test
    void testRestar() {
        assertEquals(2, Operaciones.restar(5, 3), "La resta de 5 - 3 debe ser 2");
    }

    @Test
    void testMultiplicar() {
        assertEquals(15, Operaciones.multiplicar(3, 5), "La multiplicación de 3 * 5 debe ser 15");
    }

    @Test
    void testDividir() {
        assertEquals(4, Operaciones.dividir(8, 2), "La división de 8 / 2 debe ser 4");
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Operaciones.dividir(10, 0);
        });
        assertEquals("No se puede dividir por cero.", exception.getMessage());
    }

###### 🚫 Archivo .gitignore

Evitamos subir archivos innecesarios al repositorio

# Java
*.class
*.log

# Maven
/target/

# IDEs
/.idea/
/*.iml

###### 🚀 CI/CD con GitHub Actions

Archivo .github/workflows/ci.yml 

name: Java CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Configurar JDK
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Compilar con Maven
        run: mvn clean install
      - name: Ejecutar pruebas
        run: mvn test

###### Prueba de ejecución del pipeline CI/CD

La prueba de ejecución del pipeline se realizo con exito, generando un artefacto dando la posibilidad de descargar un archivo HTML con el informe completo sobre los test.