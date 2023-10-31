import { Business } from "./business";
import { Client } from "./client";

export interface Points {
    id: number,
    loyal_points: number,
    loyal_awards: number,
    business: Business,
    client: Client
}