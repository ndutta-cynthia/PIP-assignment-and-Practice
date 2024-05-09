fun main(){
    val app = SocialMediaApp()
    val user1Id = 1
    val user2Id = 2
    app.follow(user1Id, user2Id)
    val followersOfUser2 = app.getFollowers(user2Id)
    println("Followers of User 2: $followersOfUser2")
    app.unfollow(user1Id, user2Id)
    val followersOfUser2AfterUnfollow = app.getFollowers(user2Id)
    println("Followers of User 2 after unfollow: $followersOfUser2AfterUnfollow")
}

class SocialMediaApp {
    private val followers: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun follow(followerId: Int, followedId: Int) {
        followers.computeIfAbsent(followedId) { mutableListOf() }.add(followerId)
    }

    fun getFollowers(userId: Int): List<Int> {
        return followers[userId] ?: emptyList()
    }

    fun unfollow(followerId: Int, followedId: Int) {
        followers[followedId]?.remove(followerId)
    }
}

