<!doctype html>
<html lang="pt-br">
<head>
    <!-- Metadados básicos da página -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Clínica Saúde & Bem-Estar oferece serviços de saúde com qualidade e responsabilidade.">
    <meta name="author" content="Clínica Saúde & Bem-Estar">    
    <link rel="icon" type="image/png" href="img/favicon.png">
    <title>Clínica Saúde & Bem-Estar</title>

    <!-- Estilos -->
    <link href="css/style.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

<div class="container">
  <!-- Cabeçalho do site com navegação -->
  <header class="header border-bottom lh-1 py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <!-- Logo da clínica -->
      <div class="col-4">
        <img src="img/logo.png" alt="Logotipo da Clínica Saúde & Bem-Estar" height="72">
      </div>      
      <!-- Informações de contato -->
      <div class="col-4 d-flex justify-content-end align-items-center">
        <span>Contato: (61) 99999-1234</span>
      </div>
    </div>
    <br>

    <!-- Links de navegação para as seções -->
    <nav class="nav justify-content-center">
    <a class="btn btn-secondary my-2 mx-1" href="#welcome-section" style="width: 20%;">Bem-vindo</a>
    <a class="btn btn-secondary my-2 mx-1" href="#services-section" style="width: 20%;">Serviços</a>
    <a class="btn btn-secondary my-2 mx-1" href="#medical-section" style="width: 20%;">Atendimento Médico</a>
    </nav>
  
  </header>
  <!-- Conteúdo principal -->
  <main class="container mt-4">
    <!-- Seção de boas-vindas -->
    <div id="welcome-section" class="p-4 p-md-5 mb-4 bg-light rounded">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1 class="display-6 fst-italic">Seja Bem-vindo à</h1>
                <h1 class="display-4 fst-italic fw-bold text-secondary">Clínica Saúde & Bem-Estar</h1>
                <p class="lead my-3">Oferecemos uma variedade de serviços de saúde para cuidar bem de você e de sua família.</p>
            </div>
        </div>
    </div>

    <!-- Chamada para os serviços -->
    <div id="services-section" class="row mb-5">
        <div class="col-md-6">    
            <h1>Conheça nossos serviços</h1>
        </div>
    </div>
    
    <!-- Listagem de serviços -->
    <!-- Atendimento Médico -->
    <div id="medical-section" class="row mb-2">
      <div class="col-md-6">
        <div class="h-md-250">         
          <h2>Atendimento Médico</h2>
          <p>Contamos com uma equipe de médicos especializados nas mais diversas áreas da saúde, prontos para atendê-lo.</p>
        </div>
      </div>
      <!-- Exames Laboratoriais e de Imagem -->
      <div class="col-md-6">
        <div class="h-md-250">
          <h2>Exames Laboratoriais e de Imagem</h2>
          <p>Realize seus exames em um ambiente equipado com tecnologia de ponta e com a segurança que você precisa.</p>
        </div>
      </div>
    </div>

    <!-- Aconselhamento Nutricional e Psicologia -->
    <div class="row mb-2">
      <div class="col-md-6">
        <div class="h-md-250">
          <h2>Aconselhamento Nutricional</h2>
          <p>Nossos nutricionistas estão prontos para auxiliá-lo a ter uma vida mais saudável e equilibrada.</p>
        </div>
      </div>
      <div class="col-md-6">
        <div class="h-md-250">
          <h2>Psicologia e Terapia</h2>
          <p>Oferecemos suporte psicológico e terapias para promover seu bem-estar mental e emocional.</p>
        </div>
      </div>
    </div>

    <!-- Fisioterapia e Check-up Geral -->
    <div class="row mb-2">
      <div class="col-md-6">
        <div class="h-md-250">
          <h2>Fisioterapia</h2>
          <p>Tratamentos personalizados de fisioterapia para recuperação e melhoria da mobilidade e redução de dores.</p>
        </div>
      </div>
      <div class="col-md-6">
        <div class="h-md-250">
          <h2>Check-up Geral</h2>
          <p>Programas completos de check-up para prevenção e controle da saúde, adequados para todas as idades.</p>
        </div>
      </div>
    </div>
  </main>

  <!-- Rodapé do site -->
  <footer class="footer py-5 bg-light">
    <div class="row">
      <div class="col-12 col-md">
        <small class="d-block mb-3 text-muted">&copy; 2024 Clínica Saúde & Bem-Estar</small>
        <small class="d-block mb-3 text-muted">CNPJ: 11.222.333/0001-10</small>
      </div>
    </div>
  </footer>
</div>

<!-- Scripts Bootstrap e personalizado (JavaScript) -->
<script src="https://getbootstrap.com/docs/5.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/script.js"></script>
</body>
</html>
