package steps;

import cucumber.api.PendingException;
import data.DataYaml;
import org.junit.Assert;
import pages.*;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import java.util.HashMap;

public class AtivacaoTagSteps {

    private AtivacaoTagPage ativacaoTagPage = new AtivacaoTagPage();
    private DocumentosBasicoPage documentosBasicoPage = new DocumentosBasicoPage();
    private PlanosPage planosPage = new PlanosPage();
    private VeiculoPage veiculoPage = new VeiculoPage();
    private ValidaDadosAtivacaoPage validaDadosAtivacaoPage = new ValidaDadosAtivacaoPage();
    private DocumentosPessoaisPage documentosPessoaisPage = new DocumentosPessoaisPage();
    private EnderecoPage enderecoPage = new EnderecoPage();
    private CriarSenhaPage criarSenhaPage = new CriarSenhaPage();

    @Dado("^eu tenha uma tag da conectcar pronta para ativar$")
    public void euTenhaUmaTagDaConectcarProntaParaAtivar()  {

    }

    @Quando("^eu efetuar ativacao de tag com plano completo$")
    public void euEfetuarAtivacaoDeTagComPlanoCompleto()  {
        HashMap massa = DataYaml
                .getMapYamlValues("AtivacaoTag","ativacao_tag_valida_plano_completo");
        ativacaoTagPage.isPresent();
        ativacaoTagPage.preencheDadosAtivacao(massa);
        documentosBasicoPage.isPresent();
        documentosBasicoPage.preencheDadosBasicos(massa);
        planosPage.isPresent();
        planosPage.escolherPlano(massa);
        veiculoPage.isPresent();
        veiculoPage.preencherDados(massa);
        validaDadosAtivacaoPage.isPresent();
        Assert.assertTrue(validaDadosAtivacaoPage.isValidaDados(massa));
        validaDadosAtivacaoPage.continua();
        documentosPessoaisPage.isPresent();
        documentosPessoaisPage.preencheDadosPessoais();
        enderecoPage.isPresent();
        enderecoPage.preencheDadosEndereco();
        criarSenhaPage.isPresent();
        criarSenhaPage.preencheDadosEndereco();
    }

    @Quando("^eu efetuar ativacao de tag com plano urbano$")
    public void euEfetuarAtivacaoDeTagComPlanoUrbano() throws Throwable {
        HashMap massa = DataYaml
                .getMapYamlValues("AtivacaoTag","ativacao_tag_valida_plano_urbano");
        ativacaoTagPage.isPresent();
        ativacaoTagPage.preencheDadosAtivacao(massa);
        documentosBasicoPage.isPresent();
        documentosBasicoPage.preencheDadosBasicos(massa);
        planosPage.isPresent();
        planosPage.escolherPlano(massa);
        veiculoPage.isPresent();
        veiculoPage.preencherDados(massa);
        validaDadosAtivacaoPage.isPresent();
        Assert.assertTrue(validaDadosAtivacaoPage.isValidaDados(massa));
        validaDadosAtivacaoPage.continua();
        documentosPessoaisPage.isPresent();
        documentosPessoaisPage.preencheDadosPessoais();
        enderecoPage.isPresent();
        enderecoPage.preencheDadosEndereco();
        criarSenhaPage.isPresent();
        criarSenhaPage.preencheDadosEndereco();
    }

    @Quando("^eu efetuar ativacao de tag com plano rodovias$")
    public void euEfetuarAtivacaoDeTagComPlanoRodovias() throws Throwable {
        HashMap massa = DataYaml
                .getMapYamlValues("AtivacaoTag","ativacao_tag_valida_plano_rodovias");
        ativacaoTagPage.isPresent();
        ativacaoTagPage.preencheDadosAtivacao(massa);
        documentosBasicoPage.isPresent();
        documentosBasicoPage.preencheDadosBasicos(massa);
        planosPage.isPresent();
        planosPage.escolherPlano(massa);
        veiculoPage.isPresent();
        veiculoPage.preencherDados(massa);
        validaDadosAtivacaoPage.isPresent();
        Assert.assertTrue(validaDadosAtivacaoPage.isValidaDados(massa));
        validaDadosAtivacaoPage.continua();
        documentosPessoaisPage.isPresent();
        documentosPessoaisPage.preencheDadosPessoais();
        enderecoPage.isPresent();
        enderecoPage.preencheDadosEndereco();
        criarSenhaPage.isPresent();
        criarSenhaPage.preencheDadosEndereco();
    }

    @Quando("^eu efetuar ativacao de tag com plano basico$")
    public void euEfetuarAtivacaoDeTagComPlanoBasico() throws Throwable {
        HashMap massa = DataYaml
                .getMapYamlValues("AtivacaoTag","ativacao_tag_valida_plano_basico");
        ativacaoTagPage.isPresent();
        ativacaoTagPage.preencheDadosAtivacao(massa);
        documentosBasicoPage.isPresent();
        documentosBasicoPage.preencheDadosBasicos(massa);
        planosPage.isPresent();
        planosPage.escolherPlano(massa);
        veiculoPage.isPresent();
        veiculoPage.preencherDados(massa);
        validaDadosAtivacaoPage.isPresent();
        Assert.assertTrue(validaDadosAtivacaoPage.isValidaDados(massa));
        validaDadosAtivacaoPage.continua();
        documentosPessoaisPage.isPresent();
        documentosPessoaisPage.preencheDadosPessoais();
        enderecoPage.isPresent();
        enderecoPage.preencheDadosEndereco();
        criarSenhaPage.isPresent();
        criarSenhaPage.preencheDadosEndereco();;
    }

    @Entao("^sera apresentado a ativacao efetuada com sucesso$")
    public void seraApresentadoAAtivacaoEfetuadaComSucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
