## SpotifySearch

This Java project allows you to search for artist information using the **Spotify Web API**.

It retrieves data such as:
- Artist popularity
- Profile image
- Musical genres
- Number of followers
- Spotify ID and other metadata

---

## How it works
The application sends requests to the Spotify Web API and processes the response to display artist data based on the name provided by the user.

---

## How to use

### 1. Create a Spotify Developer application
1. Go to **Spotify for Developers**
2. Log in with your Spotify account
3. Create a new application
4. Copy your **Client ID** and **Client Secret**

---

### 2. Configure environment variables
Create a `.env` file in the root of the project and add:

```env
CLIENT_ID=your_client_id_here
CLIENT_SECRET=your_client_secret_here
```
---

You're all set, just type your favorite artist and enjoy the results.