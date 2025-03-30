# 🏨 Hootel - Sistema de Gestão para Hotel, Cruzeiro e Spa  

**Hootel** é uma aplicação web que integra três módulos distintos para a gestão de **hotéis, cruzeiros e spas**, utilizando uma abordagem de **framework reutilizável**. O projeto foi desenvolvido com **padrões de projeto**, como o **Strategy**, para maximizar a reutilização de código e a flexibilidade do sistema.

## 🚀 Tecnologias Utilizadas  

### **Backend:**  
- **Spring Boot** (estruturação e API REST)  
- **JPA + Hibernate** (persistência de dados)  
- **PostgreSQL** (banco de dados)  
- **Docker** (containerização)  
- **Maven** (gerenciamento de dependências)  

### **Frontend:**  
- **Thymeleaf** 

---

## 📜 Funcionalidades  
✔ Reserva e cancelamento de serviços  
✔ Registro de serviços adicionais  
✔ Sistema de avaliação anônima no check-out
✔ Consulta às informações triviais do estabelecimento
✔ Monitoramento de alternativas para alimentação
✔ Acesso ao cronograma de eventos previamente planejados
✔ Recomendação de eventos - Strategy 
✔ Recomendação de refeições - Strategy
✔ Agendamento de serviços específicos

---

## 🖥️ Como Executar o Projeto  

### 🔧 **Prérequisitos:**  
Certifique-se de ter instalado:  
- [Java 17+](https://adoptium.net/)  
- [Maven](https://maven.apache.org/)  

### 🏗 **Rodando o Backend**  

```bash
# Clone o repositório
git clone https://github.com/giovvbat/hootel.git

# Acesse a pasta do backend
cd hootel

# Compile e execute o backend
./mvnw clean package
java -jar target/*.jar
```

O backend estará disponível em **http://localhost:8080**.  

---


## 📄 Licença  

Este projeto está sob a licença **MIT**.  


