plugins {
    id("java")
    application
}

group = "com.auzeill.java.ast"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.sonarsource.api.plugin:sonar-plugin-api:9.8.0.203") // tested with 9.8.0.203
    implementation("org.sonarsource.sonarqube:sonar-plugin-api-impl:9.4.0.54424") // tested with 9.7.1.62043
    implementation("org.sonarsource.java:java-frontend:7.15.0.30507") // tested with 7.15.0.30507

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

application {
    mainClass.set("com.auzeill.java.ast.PrintAST")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.auzeill.java.ast.PrintAST"
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
