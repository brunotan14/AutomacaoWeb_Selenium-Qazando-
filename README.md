# 🚀 Automação Web com Selenium + Java

Bem-vindo ao projeto **AutomacaoWeb_Selenium-Qazando** 🎯
Este repositório contém um **framework de automação de testes web** desenvolvido em **Java**, com foco em **boas práticas, organização e integração contínua**.

---

## 🧪 Sobre o projeto

O objetivo deste projeto é validar funcionalidades de uma aplicação web de forma **automatizada**, garantindo **qualidade**, **confiabilidade** e **feedback rápido** durante o desenvolvimento.

O framework foi pensado para ser:

* 📦 Escalável
* 🧹 Organizado
* 🤖 Pronto para CI/CD
* 📊 Rico em evidências (relatórios e screenshots)

---

## 🛠️ Tecnologias utilizadas

* ☕ **Java**
* 🌐 **Selenium WebDriver**
* 🧪 **JUnit 4**
* 📄 **Maven**
* 📊 **Extent Reports**
* 🧱 **Page Object Model (POM)**
* 🐙 **Git & GitHub**
* 🤖 **GitHub Actions (CI)**

---

## 📁 Estrutura do projeto

```bash
src
 └── test
     └── java
         ├── base        # Base do framework (setup, teardown, regras)
         ├── pages       # Page Objects
         ├── tests       # Casos de teste
         ├── report      # Configuração de relatórios
         ├── Run         # Guarda o driver
```

---

## 🧱 Padrão de projeto

O framework utiliza **Page Object Model (POM)** para:

* Separar regras de negócio da automação
* Facilitar manutenção
* Reaproveitar código
* Melhorar legibilidade dos testes

---

## 📊 Relatórios e Evidências

✔ Relatório HTML gerado automaticamente
✔ Screenshot automático em caso de falha
✔ Evidência salva localmente para análise

📁 Local:

```bash
target/
 ├── extent-report.html
 └── screenshots/
```

---

## ▶️ Como executar os testes

### 🔹 Execução local

```bash
mvn test
```

### 🔹 Execução em modo headless (CI)

```bash
mvn test -Dbrowser=chrome-ci
```

---

## 🤖 Integração Contínua (CI)

Este projeto possui **pipeline configurado no GitHub Actions**:

* 🚀 Execução automática a cada **Pull Request**
* ⏰ Execução agendada (cron)
* 🧪 Testes rodando em **Chrome Headless**
* 📎 Relatórios e screenshots disponíveis como artifacts

---

## 🎯 Benefícios do framework

✅ Feedback rápido sobre falhas
✅ Evidências claras de erro
✅ Facilidade de manutenção
✅ Pronto para times ágeis
✅ Boa base para evolução (Allure, paralelismo, tags, etc.)

---

## 👨‍💻 Autor

**Bruno Nathan**
QA | Automação de Testes | Selenium | Java

🔗 GitHub: [https://github.com/brunotan14](https://github.com/brunotan14)
🔗 LinkedIn: (adicione aqui)

---

## 🚀 Considerações finais

Este projeto representa a aplicação prática de conceitos importantes de **automação de testes**, **qualidade de software** e **integração contínua**, servindo como base sólida para projetos reais em ambiente profissional.

Obrigado por visitar o repositório 🙌
Fique à vontade para explorar, clonar e evoluir este projeto!
