package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import data.DataYaml;
import model.TagModel;
import org.junit.Assert;
import pages.*;
import support.Verifications;

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
        ativacaoTagPage.acessarPagina();
        TagModel tagModel = new TagModel();
        TagModel.setTagId(tagModel.selectTagId());
    }

    @Quando("^eu efetuar ativacao de tag com plano \"([^\"]*)\"$")
    public void euEfetuarAtivacaoDeTagComPlano(String plano) throws Throwable {
        HashMap massa = DataYaml
                .getMapYamlValues("ativacao/AtivacaoTag","ativacao_tag_valida_plano_"+plano);
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

    @Entao("^sera apresentado a ativacao efetuada com sucesso$")
    public void seraApresentadoAAtivacaoEfetuadaComSucesso() {
        Assert.assertEquals(false,criarSenhaPage.isMensagemErroShow());
    }
}
