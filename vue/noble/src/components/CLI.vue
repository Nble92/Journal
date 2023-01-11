<template>
    <div class="cli">
      <div class="cli__prompt">{{ prompt }}</div>
      <div class="cli__input">
        <form @submit.prevent="handleSubmit">
          <input v-model="input" ref="input" @keydown.up="handlePreviousCommand" @keydown.down="handleNextCommand" class="cli__input-field" type="text" :placeholder="prompt">
          <button class="cli__input-submit" type="submit">Run</button>
        </form>
      </div>
      <div class="cli__output" ref="output">
        <div v-for="line in output" :key="line.id" class="cli__output-line">{{ line.text }}</div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        prompt: '$',
        input: '',
        output: [],
        commandHistory: []
      }
    },
    methods: {
      handleSubmit() {
        // Perform some action with the input, such as running a command
        let input = this.input.trim()
        if (input) {
          this.commandHistory.push(input)
          this.output.push({ text: `${this.prompt} ${input}` })
          this.input = ''
          this.$refs.input.focus()
        }
      },
      handlePreviousCommand() {
        if (this.commandHistory.length > 0) {
          this.input = this.commandHistory[this.commandHistory.length - 1]
        }
      },
      handleNextCommand() {
        this.input = ''
      }
    },
    mounted() {
      this.$refs.input.focus()
    }
  }
  </script>
  
  <style>
  .cli {
    font-family: monospace;
  }
  
  .cli__prompt {
    color: #4d4d4d;
  }
  
  .cli__input {
    display: flex;
    align-items: center;
    padding: 8px;
  }
  
  .cli__input-field {
    border: none;
    outline: none;
    font-size: 14px;
    padding: 4px;
    flex: 1;
    margin-right: 8px;
  }
  
  .cli__input-submit {
    background-color: #4d4d4d;
    color: #fff;
    border: none;
    padding: 4px 8px;
    font-size: 14px;
    cursor: pointer;
  }
  
  .cli__output {
    padding: 8px;
  }