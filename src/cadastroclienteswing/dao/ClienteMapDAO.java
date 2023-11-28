/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclienteswing.dao;

import cadastroclienteswing.domain.Cliente;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mathe
 */
public class ClienteMapDAO implements IClienteDAO {

    private Map <Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())){ //se tiver o atributo cpf do cliente no map, false
            return false;
        }
        this.map.put(cliente.getCpf(), cliente); //se nao, coloca o cpf, e o cliente no map, true
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null){
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) { //obj de entrada
        Long cpf = cliente.getCpf(); // tras o valor cpf do obj cliente

        Cliente clienteCadastrado = this.map.get(cpf); //obj do map
        if (clienteCadastrado != null){
            clienteCadastrado.setNome(cliente.getNome()); //nome do obj no map,é = o nome do obj entrada
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
