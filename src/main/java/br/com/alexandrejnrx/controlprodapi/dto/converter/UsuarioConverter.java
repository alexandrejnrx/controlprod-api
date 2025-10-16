package br.com.alexandrejnrx.controlprodapi.dto.converter;

import br.com.alexandrejnrx.controlprodapi.dto.UsuarioRequestDTO;
import br.com.alexandrejnrx.controlprodapi.dto.UsuarioResponseDTO;
import br.com.alexandrejnrx.controlprodapi.model.Usuario;

public class UsuarioConverter {

    public static Usuario converterDTOParaEntidade(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setNomeUsuario(usuarioRequestDTO.getNomeUsuario());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());

        return usuario;
    }

    public static UsuarioResponseDTO converterEntidadeParaDTO(Usuario usuario) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();

        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setNomeUsuario(usuario.getNomeUsuario());
        usuarioResponseDTO.setEmail(usuario.getEmail());

        return usuarioResponseDTO;
    }
}
