<template>
    <form @submit.prevent="handleSubmit"> 
        <!--submit.prevent prevents page from reloading-->
        <div>
            <label for="title">Title:
                <input id="title" v-model="form.title" required />
            </label>
        </div>
        <div>
            <label for="author">Author:
                <input id="author" v-model="form.author" required />
            </label>
        </div>
        <button type="clear">Clear</button>
        <button type="submit">Submit</button>
    </form>
</template>

<script>
export default {
    props: ['book'], //book is a property
    data() {
        return {
            form: {
                title: this.book?.title || "",
                author: this.book?.author || ""
            }
        };
    },
    methods: {
        handleSubmit() {
            this.$emit('submit', ...this.form) //emit data to parent component
            //...this.form makes this.form into a new object
        }
    }
}
</script>