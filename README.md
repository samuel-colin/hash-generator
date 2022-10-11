# Hash Generator

---
## Example 

**METHOD**
> POST

**URL**
> http://localhost:8888/hash

**BODY** 
> {
> "data" : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sagittis eros eu porta interdum.",
> "hashMethod" : "HmacSHA256",
> "secretKey" : "secret123"
> }

The "hashMethod" element can have 2 values "HmacSHA256" or "SHA-256".

**RESULT**
> 200 OK
> 012a8af64f71315be25fe60acc69341acac93d2ff253ad4a6b12ea38cfc709a6