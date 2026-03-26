FROM maven:3.9.6-eclipse-temurin-17
#imagem construida com base no linux debian/ubuntu

WORKDIR /app

# Copia dependências primeiro (cache)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copia o restante
COPY . .

# Executa testes ao rodar o container
CMD ["mvn", "clean", "test", "-Dbrowser=chrome-ci"]