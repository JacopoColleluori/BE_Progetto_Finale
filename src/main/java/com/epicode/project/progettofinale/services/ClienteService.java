package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
   Page<Cliente> getAllCliente(Pageable pageable);
}
