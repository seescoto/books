<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="book in books" :key="book.id">
                    <td>{{ book.id }}</td>
                    <td>{{ book.title }}</td>
                    <td>{{ book.author }}</td>
                    <td>
                        <button @click="$emit('edit-book', book.id)">Edit</button>
                        <button @click="$emit('delete-book', book.id)">Delete</button>
                    </td>
                </tr>
            </tbody>

        </table>
    </div>
</template>

<script>
//only needed property is 'books'
export default {
    props: ['books']
};
</script>