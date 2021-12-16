import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import {Gift} from '../models/Gift.ts';

@Injectable({
    providedIn: 'root'
})
export class CadeauHttpService{

    baseUrl ="http:/localhost:8080/gifts"

    constructor(private http: HttpClient){}

    public findAll(){
        return this.http.get<Gift[]>(this.baseUrl)
    }

    public deleteById(){
        return this.http.delete(this.baseUrl)
    }
}