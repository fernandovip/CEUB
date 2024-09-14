# Controle de Compras na Internet

Esta é uma extensão do Google Chrome para controlar e monitorar as compras feitas na internet. A extensão registra automaticamente as compras em uma planilha do Google Drive e exibe gráficos que mostram os gastos totais, mensais e anuais do usuário. Além disso, permite que o usuário insira seu valor de receita mensal para controle financeiro.

## Funcionalidades

- **Registro Automático de Compras:** Registra automaticamente as compras realizadas online em uma planilha no Google Drive.
- **Exibição de Gráficos Financeiros:** Mostra gráficos com os gastos totais, mensais e anuais.
- **Inserção de Receita Mensal:** Permite ao usuário inserir seu valor de receita mensal.
- **Indicação de Situação Financeira:** Altera a cor da interface (verde, amarela ou vermelha) com base no saldo entre os valores recebidos e gastos.

## Como Usar

### Requisitos

- Navegador Google Chrome.
- Conta do Google para autenticação e acesso ao Google Drive.

### Instalação

1. Clone ou faça o download deste repositório.
2. No Chrome, acesse `chrome://extensions/`.
3. Ative o "Modo do desenvolvedor".
4. Clique em "Carregar sem compactação" e selecione a pasta do projeto.
5. A extensão será adicionada ao Chrome.

### Configuração do Google Drive

1. Crie credenciais na [Google Cloud Platform](https://console.cloud.google.com/).
2. Habilite a API do Google Drive.
3. Insira o `client_id` gerado no arquivo `manifest.json` em `oauth2.client_id`.

### Uso

1. Clique no ícone da extensão na barra de ferramentas do Chrome.
2. Insira os detalhes da compra (valor, data, etc.) na interface da extensão.
3. A compra será registrada na planilha do Google Drive.
4. Visualize os gráficos para acompanhar seus gastos e controle financeiro.

## Estrutura do Projeto

controle_compras_extensao/
├── src/
│   ├── css/
│   │   └── styles.css
│   ├── js/
│   │   ├── background.js
│   │   ├── popup.js
│   └── popup.html
├── manifest.json
└── README.md

## Tecnologias Utilizadas

- HTML, CSS, JavaScript
- API do Google Drive
- Chrome Extensions API

## Contribuindo

Contribuições são bem-vindas! Se você tiver sugestões, melhorias ou correções, fique à vontade para enviar um pull request.

## Agradecimentos

- Fernando Campina dos Santos

---

**Nota:** Este é um projeto de exemplo e pode requerer ajustes adicionais para uso em produção, especialmente em relação à segurança e privacidade dos dados.

