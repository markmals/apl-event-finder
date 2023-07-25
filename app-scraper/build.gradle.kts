import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("project-build.common")
	id("org.springframework.boot") version "2.7.13"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("plugin.spring") version "1.6.21"
}

dependencies {
	implementation(project(":lib-elasticsearch"))
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("com.google.guava:guava:32.1.1-jre")
	implementation("org.fissore:slf4j-fluent:0.14.0")

	implementation("rome:rome:1.0") // for RSS feed
	implementation("org.jsoup:jsoup:1.16.1") // for web scraping

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.assertj:assertj-core:3.24.2")
}
