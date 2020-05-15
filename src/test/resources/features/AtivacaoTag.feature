# language: pt
# charset: UTF-8

@PlanId=67660
@SuiteId=67661
Funcionalidade: Ativação Tag
   Eu como cliente gostaria de acessar o sistema e ativar minha Tag da ConectCar

   @TestId=67676
   Cenario: Realizar ativação plano Completo (Regressivo)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "completo"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=67677
  Cenario: Realizar ativação plano Urbano (Regressivo)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "urbano"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=67678
  Cenario: Realizar ativação plano Rodovias (Regressivo)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "rodovias"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=67679
  Cenario: Realizar ativação plano Basico (Regressivo)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "basico"
    Entao sera apresentado a ativacao efetuada com sucesso
