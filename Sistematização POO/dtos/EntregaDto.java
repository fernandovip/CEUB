package com.aula.entrega.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregaDto (
    @NotBlank String nome,
    @NotBlank String cpf,
    @NotBlank String capacidadeveiculo) {
	
}