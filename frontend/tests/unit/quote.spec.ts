import { shallowMount } from "@vue/test-utils";
import Quote from "@/components/Quote.vue";

describe("Quote.vue", () => {
  it("renders props.quote when passed", () => {
    const quote = {
      original: "Hey"
    };
    const wrapper = shallowMount(Quote, {
      propsData: { quote }
    });
    expect(wrapper.find(".blockquote").text()).toMatch("Hey");
  });
});
