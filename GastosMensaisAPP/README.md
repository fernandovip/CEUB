# Gastos Mensais - Aplicativo Android

## Descrição do Projeto

O aplicativo **Gastos Mensais** é uma aplicação Android desenvolvida para ajudar os usuários a registrarem e acompanharem seus gastos mensais. Através dele, é possível cadastrar, visualizar, editar e excluir gastos, fornecendo uma visão clara do total gasto até o momento. O aplicativo foi desenvolvido util![img_2.png](app/img_2.png)izando o SQLite para armazenar dados localmente. A interface é simples e intuitiva, garantindo uma experiência de uso agradável e prática.

## Autor

- [Fernando Campina dos Santos]

## Instruções de Instalação

### Clonar o Repositório
* Clone o repositório para sua máquina local.
  git clone <URL do repositório>

### Abrir no Android Studio
* Abra o Android Studio e selecione a opção Open an existing Android Studio project.
* Navegue até a pasta onde o repositório foi clonado e abra o projeto.

### Configurar Dependências
* Certifique-se de que o build.gradle está configurado corretamente (caso tenha dependências específicas).
* Clique em Sync Now para sincronizar o projeto com as dependências.

### Executar no Emulador ou Dispositivo
* Conecte um dispositivo físico ou inicie um emulador.
* No Android Studio, selecione o dispositivo de destino e clique em Run para instalar e executar o aplicativo.

## Funcionalidades Desenvolvidas

### Tela Principal
  * Exibe o total gasto até o momento e a lista de todos os gastos cadastrados.
  * Possui um botão "Cadastrar" para adicionar um novo gasto.
  * Cada item da lista de gastos é clicável, levando o usuário para a tela de detalhes do gasto.

### Cadastro de Gastos
  *	Formulário para adicionar novos gastos com os campos: Descrição, Valor e Data.
  *	Validação dos campos:
    *	Descrição: Não pode estar vazia e deve ter no máximo 50 caracteres.
    *	Valor: Deve ser numérico, sem letras.
    *	Data: Deve estar no formato dd/MM/yyyy.
  *	Impede a duplicação de um gasto com a mesma descrição no mesmo mês.
  *	O botão de ação "Cadastrar" é alterado para "Editar" ao atualizar um gasto existente.
  *	Após o cadastro, a tela é finalizada e o usuário retorna à lista de gastos atualizada.

### Detalhes do Gasto
  * Exibe as informações detalhadas do gasto selecionado.
  * Botões Editar e Excluir:
    * Editar: Abre a tela de cadastro com os dados preenchidos, permitindo alterações.
    * Excluir: Remove o gasto selecionado e retorna à tela principal com a lista de gastos atualizada.

### Armazenamento Local com SQLite
  * Banco de dados local (gastos.db) criado com SQLite para armazenar os dados dos gastos.
  * O banco de dados permite operações de CRUD (Create, Read, Update, Delete) para gerenciar os registros.
  * Utilização do Database Inspector no Android Studio para visualizar e depurar o banco de dados.
