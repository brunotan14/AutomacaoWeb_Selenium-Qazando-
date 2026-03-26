FROM selenium/standalone-chrome:145.0-chromedriver-145.0-20260222

USER root

WORKDIR /app

# Garante que o container tenha Maven para executar os testes do projeto.
RUN apt-get update \
  && apt-get install -y maven \
  && rm -rf /var/lib/apt/lists/*

# Copia dependências primeiro (cache)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copia o restante
COPY . .

# Evita interferência do ENTRYPOINT da imagem base.
ENTRYPOINT ["mvn"]
CMD ["-B", "clean", "test", "-Dbrowser=chrome-ci"]