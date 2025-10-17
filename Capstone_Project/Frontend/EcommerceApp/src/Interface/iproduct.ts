export interface IProduct {
    id?:number
    productName:string
    productDesc:string
    productCat:string
    make:string
    availableQty:number
    price:number
    uom:string
    prodRating:number
    imgUrl:string
    dateOfManufacture?:Date
}
