package org.iesvdm.videoclub.service;

import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.exception.CategoriaNotFoundException;
import org.iesvdm.videoclub.exception.PeliculaNotFoundException;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private Categoria categoria;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> all() {
        List<Object[]> lista = this.categoriaRepository.queryCount();
        List<Categoria> all = this.categoriaRepository.findAll();

        var l = all.stream().map(categoria1 -> {

            Object obj= lista.stream().filter(objects -> {
               Integer objetoInt = (int) objects[0];
             return objetoInt == categoria.getIdCategoria();})
                .map(objects -> objects[1]).findFirst().get();

            Integer conteo = (int) obj;
            categoria1.setConteo(conteo); return categoria1;}).collect(toList());

        return all;
    }

    public Map<String, Object> all(int pagina, int tamanio){

        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("idCategoria").ascending());

        Page<Categoria> pageAll = this.categoriaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("categorias", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
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
            if (ordenarOptional.get().equalsIgnoreCase("asc")) {
                return this.categoriaRepository.queryOrdenarAsc(ordenarOptional);
            } else if(ordenarOptional.get().equalsIgnoreCase("desc")){
                return this.categoriaRepository.queryOrdenarDesc(ordenarOptional);
            }
        } else if (buscarOptional.isPresent() && !ordenarOptional.isPresent()) {
            return this.categoriaRepository.queryBuscar(buscarOptional);
        }

        return this.categoriaRepository.findAll();
    }

}
