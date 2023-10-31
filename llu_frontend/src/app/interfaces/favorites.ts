import { Business } from "./business";
import { Client } from "./client";

export interface Favorites {
    id: number,
    business: Business,
    client: Client
}