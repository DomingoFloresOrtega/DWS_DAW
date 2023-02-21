package org.iesvdm.videoclub.service;

import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.exception.CategoriaNotFoundException;
import org.iesvdm.videoclub.exception.PeliculaNotFoundException;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getIdCategoria())  ?
                                                            this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(p -> {this.categoriaRepository.delete(p);
                                                        return p;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public List<Categoria> allByQueryFiltersStream(Optional<String> buscarOptional, Optional<String> ordenarOptional){
        if (buscarOptional.isPresent() && ordenarOptional.isPresent()) {
            return this.categoriaRepository.queryBuscarOrdenar(buscarOptional, ordenarOptional);
        } else if (!buscarOptional.isPresent() && ordenarOptional.isPresent()) {
            return this.categoriaRepository.queryOrdenar(ordenarOptional);
        } else if (buscarOptional.isPresent() && !ordenarOptional.isPresent()) {
            return this.categoriaRepository.queryBuscar(buscarOptional);
        }

        return this.categoriaRepository.findAll();
    }

}
