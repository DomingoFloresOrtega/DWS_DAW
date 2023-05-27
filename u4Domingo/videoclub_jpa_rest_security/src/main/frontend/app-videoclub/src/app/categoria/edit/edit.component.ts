import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CategoriaService} from "../categoria.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Categoria} from "../categoria";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id: number = 0;
  categoria: Categoria = { idCategoria: 0, nombre: "VOID", ultimaActualizacion: "1970-01-01", idioma: { id: 0, nombre: 'VOID', ultimaActualizacion: "1970-01-01"}};
  form: FormGroup =  new FormGroup({
    idCategoria: new FormControl('', [Validators.required]),
    nombre:  new FormControl(''
            , [ Validators.required, Validators.pattern('^[a-zA-ZÁáÀàÉéÈèÍíÌìÓóÒòÚúÙùÑñüÜ \-\']+') ]),
    idioma: new FormGroup({
      id: new FormControl('', [Validators.required]),
      nombre: new FormControl( '', [Validators.required])
    })
  });

  constructor(
    public categoriaService: CategoriaService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['idCategoria'];
    this.categoriaService.find(this.id).subscribe((data: Categoria)=>{
      this.categoria = data;

      this.form.get('idCategoria').setValue(this.categoria.idCategoria);
      this.form.get('nombre').setValue(this.categoria.nombre);
      this.form.get('idioma').get('id').setValue(this.categoria.idioma.id);
      this.form.get('idioma').get('nombre').setValue(this.categoria.idioma.nombre);

    });
  }

  get f(){
    return this.form.controls;
  }

  submit(){
    console.log(this.form.value);
    this.categoriaService.update(this.id, this.form.value).subscribe(res => {
      console.log('Categroría actualizada satisfactoriamente!');
      this.router.navigateByUrl('categoria/index').then();
    })
  }

}
