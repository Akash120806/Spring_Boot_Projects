#In Spring Boot, both `@Controller` and `@RestController` are used to create **web controllers**, but they are mainly different in **what they return**.

### 1. `@Controller`

Used when your controller returns a **view/page**, usually HTML.

```java
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

Here:

```text
Browser → /home
          ↓
     HomeController
          ↓
     return "home"
          ↓
   Find home.html
          ↓
    Display HTML page
```

So `"home"` is treated as the **name of a view/page**.

---

### 2. `@RestController`

Used when your controller returns **data**, usually JSON.

```java
@RestController
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "Akash";
    }
}
```

The browser/API client receives:

```text
Akash
```

It does **not** look for `Akash.html`.

For example:

```java
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser() {
        return new User("Akash", 22);
    }
}
```

Response might be:

```json
{
    "name": "Akash",
    "age": 22
}
```

---

## The important difference

| `@Controller`                         | `@RestController`                                      |
| ------------------------------------- | ------------------------------------------------------ |
| Mainly returns **views/pages**        | Mainly returns **data**                                |
| Commonly used for HTML                | Commonly used for REST APIs                            |
| `"home"` → looks for a view           | `"Akash"` → sends `"Akash"` as response                |
| Can return JSON using `@ResponseBody` | Automatically behaves as if `@ResponseBody` is present |

### Why does `@RestController` return data directly?

`@RestController` is basically:

```java
@Controller
@ResponseBody
```

So:

```java
@RestController
public class UserController {
}
```

is conceptually equivalent to:

```java
@Controller
@ResponseBody
public class UserController {
}
```

`@ResponseBody` means:

> **"Don't treat my return value as a webpage/view. Put it directly into the HTTP response."**

### Easy way to remember

```text
@Controller
     ↓
HTML / Web Page

@RestController
     ↓
JSON / Data / API
```

So if you're building a **frontend + Spring Boot REST API**, you'll commonly use `@RestController` for the backend API endpoints.
