import { Business } from "./business";
import { Client } from "./client";
import { Event } from "./event";

export interface Review {
    id : number,
    date_time: Date,
    grade: number,
    comment: string,
    business: Business,
    client: Client,
    event: Event
}